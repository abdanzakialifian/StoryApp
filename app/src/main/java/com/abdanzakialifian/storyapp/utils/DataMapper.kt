package com.abdanzakialifian.storyapp.utils

import com.abdanzakialifian.storyapp.data.source.local.room.entity.StoriesEntities
import com.abdanzakialifian.storyapp.data.source.remote.model.*
import com.abdanzakialifian.storyapp.domain.model.*

object DataMapper {
    fun mapRegistrationResponseToRegistration(input: RegistrationResponse): Registration =
        Registration(
            error = input.error,
            message = input.message
        )

    fun mapLoginResponseToLogin(input: LoginResponse?): Login {
        val loginResult = LoginResult(
            name = input?.loginResult?.name,
            userId = input?.loginResult?.userId,
            token = input?.loginResult?.token
        )
        return Login(
            loginResult = loginResult,
            error = input?.error,
            message = input?.message
        )
    }

    fun mapNewStoryResponseToNewStory(input: NewStoryResponse): NewStory = NewStory(
        error = input.error,
        message = input.message
    )

    fun mapStoryResponseToListStory(input: StoriesResponse): ArrayList<Stories> {
        val listStories = ArrayList<Stories>()
        input.listStory?.forEach { data ->
            val listStory = Stories(
                photoUrl = data.photoUrl,
                createdAt = data.createdAt,
                name = data.name,
                description = data.description,
                lon = data.lon,
                id = data.id,
                lat = data.lat
            )
            listStories.add(listStory)
        }
        return listStories
    }

    fun mapListStoryResponseToStoriesEntities(input: List<ListStoryResponse>?): List<StoriesEntities> {
        val listStoriesEntities = mutableListOf<StoriesEntities>()
        input?.map { data ->
            val storiesEntities = StoriesEntities(
                id = data.id ?: "",
                photoUrl = data.photoUrl ?: "",
                createdAt = data.createdAt ?: "",
                name = data.name ?: "",
                description = data.description ?: "",
                lon = data.lon ?: 0.0,
                lat = data.lat ?: 0.0
            )
            listStoriesEntities.add(storiesEntities)
        }
        return listStoriesEntities
    }

    fun mapStoriesEntitiesToStories(input: StoriesEntities): Stories = Stories(
        photoUrl = input.photoUrl,
        createdAt = input.createdAt,
        name = input.name,
        description = input.description,
        lon = input.lon,
        id = input.id,
        lat = input.lat
    )
}