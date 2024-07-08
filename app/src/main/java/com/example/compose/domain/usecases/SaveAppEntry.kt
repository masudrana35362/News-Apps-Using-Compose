package com.example.compose.domain.usecases

import com.example.compose.domain.manager.LocalUserManager

class SaveAppEntry (
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}