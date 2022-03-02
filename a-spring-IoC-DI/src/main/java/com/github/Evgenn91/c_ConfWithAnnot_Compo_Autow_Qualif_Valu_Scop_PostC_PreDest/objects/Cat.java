package com.github.Evgenn91.c_ConfWithAnnot_Compo_Autow_Qualif_Valu_Scop_PostC_PreDest.objects;

import org.springframework.stereotype.Component;

//аннотацией Component мы говорим что это bean
@Component("catBean")/* "catBean" - это id для бина(тоесть когда мы его достаем из SpringContext) */
public class Cat implements Pet {
    @Override
    public void say() {
        System.out.println("Meow Meow");
    }
}
