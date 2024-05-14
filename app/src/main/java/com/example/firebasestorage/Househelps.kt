package com.example.firebasestorage


import com.google.firebase.firestore.Exclude
import java.time.Duration

data class Househelps(
    @Exclude var courseID: String? = "",
    var househelpame: String? = "",
    var phonenumber: String? = "",
    var preferredtown: String? = "",
    var email: String? ="",
    var sizeoffamily: String? ="",
    var expectedsalary: String? ="",
    var levelofeducation: String? ="",
    var workexperience: String? ="",
    var languages: String? ="",
)