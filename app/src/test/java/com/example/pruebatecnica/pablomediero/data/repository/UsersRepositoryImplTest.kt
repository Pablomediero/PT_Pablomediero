package com.example.pruebatecnica.pablomediero.data.repository

import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import com.example.pruebatecnica.pablomediero.data.models.Info
import com.example.pruebatecnica.pablomediero.data.models.MockUserData
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UsersRepositoryImplTest {
    private lateinit var repository: UsersRepository
    private lateinit var dataSource: DataSource
    private lateinit var mockUsers: List<User>
    private lateinit var mockDuplicateUsers: List<User>

    @Before
    fun setUp() {
        dataSource = mockk()
        repository = UsersRepositoryImpl(dataSource)
        mockUsers = MockUserData.getUsers()
        mockDuplicateUsers = MockUserData.getDuplicateUsers()
    }
    @Test
    fun `Test UsersRepositoryImpl Success Response`(){
        runTest {
            coEvery { dataSource.getAllUsersData() } returns flow {
                emit(Result.success(ApiResponse(
                    results = mockUsers,
                    info = Info(
                        seed = "testSeed",
                        page = 1,
                        results = mockUsers.size,
                        version = "1.0"
                    )
                )))
            }
            val results = repository.getAllUsersData().first()

            assertTrue("Response is Success", results.isSuccess)
            assertNotNull("Response is not null", results.getOrNull())
            assertTrue("Response is not empty", results.getOrNull()?.isNotEmpty() == true)
            coVerify { dataSource.getAllUsersData() }
            assert(mockUsers.size == results.getOrNull()?.size)
        }
    }

    @Test
    fun `Test FilterDuplicateUsers mockDuplicateUsers`(){
        runTest {
            coEvery { dataSource.getAllUsersData() } returns flow {
                emit(Result.success(ApiResponse(
                    results = mockDuplicateUsers,
                    info = Info(
                        seed = "testSeed",
                        page = 1,
                        results = mockDuplicateUsers.size,
                        version = "1.0"
                    )
                )))
            }
            val results = repository.getAllUsersData().first()
            assertFalse(mockDuplicateUsers.size == results.getOrNull()?.size)
        }
    }
    @Test
    fun `Test FilterDuplicateUsers mockUsers`(){
        runTest {
            coEvery { dataSource.getAllUsersData() } returns flow {
                emit(Result.success(ApiResponse(
                    results = mockUsers,
                    info = Info(
                        seed = "testSeed",
                        page = 1,
                        results = mockUsers.size,
                        version = "1.0"
                    )
                )))
            }
            val results = repository.getAllUsersData().first()
            assertTrue(mockUsers.size == results.getOrNull()?.size)
        }
    }
}