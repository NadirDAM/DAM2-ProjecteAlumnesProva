package com.example.dam2_projectealumnesprova

public enum class CursEnum(s: String) {
    SMX1("SMX1"), SMX2("SMX2"), DAM1("DAM1"), DAM2("DAM2");


    companion object {
        fun getCursByText (name:String): CursEnum {
            for (letter in CursEnum.values()) {
                System.out.println(letter.toString().equals(name.toString()))
                System.out.println(letter)
                System.out.println(name)
                if (letter.toString().equals(name.toString())) {
                    return letter

                }
            }
            return SMX1
        }
    }
}