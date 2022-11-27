package com.dos.ua.model

class DesignData {
    /**set Data*/
    // Main for Menu
//    var nameMain:String? = null
//    var infoMain:String? = null
//    var imgMain:String? = null

    // A
    var nameA:String? = null
    var infoA:String? = null
    var imgA:String? = null

    //B
    var nameB :String? = null
    var infoB:String? = null
    var imgB:String? = null

    constructor(){}

    constructor(
//        nameMain:String?, infoMain:String?, imgMain:String?,
        nameA:String?, infoA:String?, imgA:String?,
        nameB:String?, infoB:String?, imgB:String?
    ){
//        this.nameMain = nameMain
//        this.infoMain = infoMain
//        this.imgMain = imgMain

        this.nameA = nameA
        this.infoA = infoA
        this.imgA = imgA

        this.nameB = nameB
        this.infoB = infoB
        this.imgB = imgB
    }

}