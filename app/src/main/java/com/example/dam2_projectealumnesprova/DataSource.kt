package com.example.dam2_projectealumnesprova

class DataSource {





    companion object {
        var listItemsViewModel : MutableList<AlumnesViewModel> = mutableListOf(
            AlumnesViewModel("Nadir", "18",CursEnum.DAM1),
            AlumnesViewModel("Raul", "18",CursEnum.DAM1),
            AlumnesViewModel("Pigermo", "18",CursEnum.DAM1),
        )

        fun  setItemToArray(nom: String, edat: String, curs: CursEnum ) {
            print("estoy llegando")
            listItemsViewModel.add(AlumnesViewModel(nom, edat, curs));
        }
    }
}