package com.example.dam2_projectealumnesprova

public enum class CursEnum(s: String) {
    SMX1("SMX1"), SMX2("SMX2"), DAM1("DAM1"), DAM2("DAM2");


    companion object {
        fun getCursByText (name:String): CursEnum {
            for (letter in CursEnum.values()) {
                letter.equals(name)
                return letter
            }
            return SMX1
        }
    }
}