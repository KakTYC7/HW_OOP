package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class wallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPostNotZero() {
        val post = Post(1, 1, 5, 123123123, "Test post")
        val addedPost = WallService.add(post)
        assertTrue(addedPost.id != 0)
    }

    @Test
    fun updateExistingPostTrue() {
        val post = Post(1, 1, 5, 123123, "Test post")
        WallService.add(post)
        val updatedPost = post.copy(text = "Updated test post")
        val result = WallService.update(updatedPost)
        assertTrue(result)
    }

    @Test
    fun updateNonExistingPostFalse() {
        val post = Post(1, 1, 5, 123141, "Test post")
        val result = WallService.update(post)
        assertFalse(result)
    }
}