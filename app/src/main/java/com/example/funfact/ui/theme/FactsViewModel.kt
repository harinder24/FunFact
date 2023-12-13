package com.example.funfact.ui.theme

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {
    fun generateRandomFact(selectedAnimal: String) : String{
       return if(selectedAnimal == "Dog"){
            getDogFacts().random()
        }else{
            getCatFacts().random()
        }
    }
    fun getDogFacts(): List<String> {
    val dogFacts = listOf(
        " Dogs have an extraordinary sense of smell.",
        "Basenji dogs don't bark.",
        "Dalmatians are born spotless.",
        "A greyhound is the fastest dog.",
        "Dogs dream like humans.",
        "The world's smallest dog is the Chihuahua.",
        " Dogs have three eyelids.",
        "The Basenji dog is known as the barkless dog.",
        "Dachshunds were originally bred for hunting.",
        "Dogs have a unique nose print, like human fingerprints."
    )
        return dogFacts
}
    fun getCatFacts(): List<String> {
        val catFacts = listOf(
            "Cats have five toes on their front paws but only four on the back ones.",
            "A group of cats is called a clowder.",
            "Cats can rotate their ears 180 degrees.",
            "The world's oldest known pet cat was found in a 9,500-year-old grave on the Mediterranean island of Cyprus.",
            "Cats have a special reflective layer behind their retinas, improving night vision.",
            "Cats can make over 100 different sounds.",
            "The average cat sleeps for 12-16 hours a day.",
            "Cats have retractable claws.",
            "A cat's nose print is unique, similar to a human fingerprint.",
            "Cats have a strong aversion to anything citrus."
        )
        return catFacts
    }
}
