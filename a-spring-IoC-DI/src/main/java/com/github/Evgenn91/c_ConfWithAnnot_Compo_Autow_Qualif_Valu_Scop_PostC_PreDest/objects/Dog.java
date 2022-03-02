package com.github.Evgenn91.c_ConfWithAnnot_Compo_Autow_Qualif_Valu_Scop_PostC_PreDest.objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") /* определяем как создается объект один на всех или кажды раз новый при создании объекта, которому нужет этот объект как поле */
public class Dog implements Pet {

    @Override
    public void say() { System.out.println("Gaw Gaw"); }
}
