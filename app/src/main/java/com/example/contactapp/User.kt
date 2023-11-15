package com.example.contactapp

import android.os.Parcel
import android.os.Parcelable

class User(private val id: Int, private val name: String, private val phoneNumber: String, private val email: String) : Parcelable {

    // Parcel constructor
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?: -1,
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    fun getUserID(): String {
        return id.toString()
    }

    fun getUserName(): String {
        return name
    }

    fun getUserPhone(): String {
        return phoneNumber
    }

    fun getUserEmail(): String {
        return email
    }

    override fun toString(): String {
        return "com.example.contactapp.User(id=$id, name=$name, phoneNumber=$phoneNumber, email=$email)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id.toString())
        parcel.writeString(name)
        parcel.writeString(phoneNumber)
        parcel.writeString(email)
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }
}