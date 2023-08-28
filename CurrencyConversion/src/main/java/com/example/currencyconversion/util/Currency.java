package com.example.currencyconversion.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {

    USD("USD","https://img.freepik.com/free-vector/illustration-usa-flag_53876-18165.jpg?w=1380&t=st=1692879206~exp=1692879806~hmac=9636e3948655598f19bef0ae9caf4bb7f2a07485c8eafa25ee77be9604d14e83","United States Dollar"),
    EUR("EUR","https://img.freepik.com/free-vector/illustration-european-union-flag_53876-27018.jpg?w=1380&t=st=1692879289~exp=1692879889~hmac=20fb7b131e488a27578be367ba3d450d042915e61f36d4e00b9efd381a51bfd9","Euro"),
    GBP("GBP","https://img.freepik.com/free-vector/illustration-uk-flag_53876-18166.jpg?w=1380&t=st=1692879418~exp=1692880018~hmac=929d153d1dbd6fd5694a87131cfe1eaf904f4b8626fb826bf6505cbe3d0fa7bf","Pound sterling"),
    EGP("EGP","https://img.freepik.com/free-vector/illustration-egypt-flag_53876-27140.jpg?w=1380&t=st=1692879451~exp=1692880051~hmac=090393f01a0429e7b71be89293bf94cbedf37afcdec0383994baaf8262dd3fa9","Egyptian Pound"),
    AED("AED","https://static.vecteezy.com/system/resources/thumbnails/001/416/661/small/uae-isolated-flag-vector.jpg","United Arab Emirates Dirham"),
    SAR("SAR","https://upload.wikimedia.org/wikipedia/commons/7/75/Download_Saudi_Arabia_National_Flag_Illustration_Editable_Vector_Image_for_free.jpg","Saudi Riyal"),
    KWD("KWD","https://media.istockphoto.com/id/938716998/vector/kuwait-flag.jpg?s=612x612&w=0&k=20&c=-6akFYQhRs9KeIkARWytGJqDVc5y0kjbRCIr7bzpvfg=","Kuwaiti Dinar"),
    CHF("CHF","https://img.freepik.com/free-vector/illustration-switzerland-flag_53876-27100.jpg?w=1380&t=st=1692880070~exp=1692880670~hmac=89be227ae1d9079cab4ec1904d58b2e6d732247308215a4b3c506a9421fea017","Swiss Franc"),
    CAD("CAD","https://img.freepik.com/free-vector/illustration-canada-flag_53876-27114.jpg?w=1380&t=st=1692880187~exp=1692880787~hmac=0e74af3e6cde9835f8a0b4355e672eefc285733cc4ea31e9ba3a7552c5d5665e","Canadian Dollar"),
    QAR("QAR","https://img.freepik.com/free-vector/basic-rgb_53876-165874.jpg?w=1380&t=st=1692880215~exp=1692880815~hmac=368d57b28b829ad334f41389505ff06d0cc49322c7211d8fd63776d0b341d216","Qatari Riyal");

    private final String code;
    private final String flagUrl;
    private final String desc;
}
