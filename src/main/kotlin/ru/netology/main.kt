package ru.netology

import java.util.*
import kotlin.contracts.CallsInPlace

data class Post(
    val id: Int,
    val ownerId: Int,
    val createdBy: Int = 5,
    val date: Int,
    val text: String,
    val comments: Comments? = null,
    val canPin: Boolean? = null,
    val canDelete: Boolean? = null,
    val canEdit: Boolean = false,
    val postType: String = "post",
    val attachments: Array<Attachment>? = null,
)

interface Attachment {
    val type: String
}

data class PhotoAttachment(
    val photo: Photo
) : Attachment {
    override val type: String = "photo"
}

data class VideoAttachment(
    val video: Video
) : Attachment {
    override val type: String = "video"
}

data class AudioAttachment(
    val video: Audio
) : Attachment {
    override val type: String = "audio"
}

data class FileAttachment(
    val video: File
) : Attachment {
    override val type: String = "file"
}

data class GeoAttachment(
    val video: Geo
) : Attachment {
    override val type: String = "geo"
}

data class Photo(
    val id: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val duration: Int,
    val url: String
)

data class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val url: String
)

data class Geo(
    val type: String,
    val coordinates: Objects,
    val place: Objects
)



data class Comments(
    val count: Int = 0,
    val canPost: Boolean = false,
)

object WallService {

    private var nextId = 1
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        if (index != -1) {
            posts = posts.copyOf()
            posts[index] = post
            return true
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        nextId = 1
    }
}