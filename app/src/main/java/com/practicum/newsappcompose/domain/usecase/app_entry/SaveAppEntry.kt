package com.practicum.newsappcompose.domain.usecase.app_entry

import com.practicum.newsappcompose.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}