package com.example.currencyconversion.controller;

import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.dto.CurrencyResponseDto;
import com.example.currencyconversion.dto.RateDto;
import com.example.currencyconversion.service.CurrencyConversionService;
import com.example.currencyconversion.util.Currency;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers =CurrencyConversionController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CurrencyConversionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CurrencyConversionService currencyConversionService;
    private ConversionDto conversionDto;
    private ConversionDto demoConversionDto;
    private List<ConversionDto> listConversionDto;
    private CurrencyResponseDto currencyResponseDto;
    private List<CurrencyResponseDto> listCurrencyResponseDto;
    private RateDto rateDto;
    private List<RateDto> listRateDto;
    private String from;
    private String to;

    private double amount;
    @BeforeEach
    public void init(){
        from = "USD";
        to = "EGP";
        amount = 10;
        conversionDto = new ConversionDto(from,to,amount);
        demoConversionDto = new ConversionDto(from,to,amount);
        currencyResponseDto = new CurrencyResponseDto(Currency.AED.getCode(), Currency.AED.getFlagUrl(),Currency.AED.getDesc());
        listConversionDto = new ArrayList<>();
        listConversionDto.add(conversionDto);
        listConversionDto.add(conversionDto);
        listConversionDto.add(conversionDto);
        listConversionDto.add(conversionDto);
        rateDto = new RateDto(from,to,300);
        rateDto = new RateDto(from,to,300);
        listRateDto = new ArrayList<>();
        listRateDto.add(rateDto);
        listRateDto.add(rateDto);
        listRateDto.add(rateDto);
        listRateDto.add(rateDto);

    }

    @Test
    public void getCurrenciesTest() throws Exception{
        when(currencyConversionService.getAllCurrencies()).thenReturn(listCurrencyResponseDto);
        ResultActions response = mockMvc.perform(get("/api/currency-conversions/currencies")
                    .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());
    }

    @Test
    public void convertTest() throws Exception{
        when(currencyConversionService.convert(from,to,amount)).thenReturn(conversionDto);
        ResultActions response = mockMvc.perform(get("/api/currency-conversions/convert")
                .param("from" ,from)
                .param("to" ,to)
                .param("amount" ,String.valueOf(amount))
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.value", CoreMatchers.is(conversionDto.getValue())));
    }

    @Test
    public void getRatesTest() throws Exception{
        when(currencyConversionService.getAllRates(from,to.lines().toList())).thenReturn(listRateDto);
        ResultActions response = mockMvc.perform(get("/api/currency-conversions/rates")
                .param("from" ,from)
                .param("to" , to)
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());

    }

    @Test
    public void compareTest() throws Exception{
        when(currencyConversionService.compare(from,to.lines().toList(),amount)).thenReturn(listConversionDto);
        ResultActions response = mockMvc.perform(get("/api/currency-conversions/compare")
                .param("from" ,from)
                .param("to" , to)
                .param("amount" ,String.valueOf(amount))
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());

    }
}
