package com.example.firebasestorage.models

class Teacher {
    var name:String = ""
    var phone:String = ""
    var email:String = ""
    var profession:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, phone: String, email: String, profession: String,imageUrl: String, id: String) {
        this.name = name
        this.phone = phone
        this.email = email
        this.profession = profession
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}