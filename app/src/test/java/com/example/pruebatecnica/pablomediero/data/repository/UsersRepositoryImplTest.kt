package com.example.pruebatecnica.pablomediero.data.repository

import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.models.MockUserData
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import io.mockk.mockk
import org.junit.Before

class UsersRepositoryImplTest {
    private lateinit var repository: UsersRepository
    private lateinit var dataSource: DataSource
    private lateinit var mockModels: List<User>

    @Before
    fun setUp() {
        dataSource = mockk()
        repository = UsersRepositoryImpl(dataSource)
        mockModels = MockUserData.getUsers()
    }

    /*fun `Test GetAllUsersData Success response`(){
        runTest {
            coEvery { dataSource.getAllUsersData() } returns flow {
                emit(Result.success(ApiResponse(
                    results = mockModels,
                    info = Info(
                        seed = "testSeed",
                        page = 1,
                        results = mockModels.size,
                        version = "1.0"
                    )
                )))
            }
            val results = repository.getAllUsersData().first()

            println("Resultado obtenido: ${results.isSuccess}")
            assertTrue("La respuesta debería ser exitosa", results.isSuccess)

            val response = results.getOrNull()
            assertNotNull("La respuesta no debería ser nula", response)

            assertTrue("La respuesta debería contener al menos un usuario", response?.isNotEmpty() == true)

            assertFalse(mockModels.size == response?.size)

            coVerify { dataSource.getAllUsersData() }
        }
    }*/
}