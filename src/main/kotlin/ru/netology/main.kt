package ru.netology

data class Post(
    val id: Int,
    val ownerId: Int,
    val createdBy: Int = 5,
    val date: Int,
    val text: String,
    val comments: Comments = Comments(),
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val postType: String = "post",
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