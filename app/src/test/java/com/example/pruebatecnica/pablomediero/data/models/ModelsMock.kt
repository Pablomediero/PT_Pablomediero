package com.example.pruebatecnica.pablomediero.data.models

object MockUserData {
    fun getUsers(): List<User> {
        return listOf(
            User(
                gender = "female",
                name = Name(title = "Miss", first = "Sara", last = "Autio"),
                location = Location(
                    street = Street(number = 4445, name = "Hämeentie"),
                    city = "Ylivieska",
                    state = "North Karelia",
                    country = "Finland",
                    postcode = "65767",
                    coordinates = Coordinates(latitude = "-27.3255", longitude = "148.4281"),
                    timezone = Timezone(
                        offset = "-6:00",
                        description = "Central Time (US & Canada), Mexico City"
                    )
                ),
                email = "sara.autio@example.com",
                login = Login(
                    uuid = "e04374f5-9ff4-40ca-be7e-806a2509cd00",
                    username = "tinylion117",
                    password = "interacial",
                    salt = "90qaVPp6",
                    md5 = "f66394f9880a32892d738e24988a5f12",
                    sha1 = "ad73c63ac4d6c2e6d4fe5510e4914431d2bca89b",
                    sha256 = "a7dd2de14b131b0cc48e2b1768997c36538c7db9328322d9027f3271c23e874a"
                ),
                dob = DateOfBirth(date = "1969-01-10T13:33:47.632Z", age = 55),
                registered = Registered(date = "2015-07-14T00:55:24.488Z", age = 9),
                phone = "04-057-800",
                cell = "042-125-78-25",
                id = Id(name = "HETU", value = "NaNNA940undefined"),
                picture = Picture(
                    large = "https://randomuser.me/api/portraits/women/16.jpg",
                    medium = "https://randomuser.me/api/portraits/med/women/16.jpg",
                    thumbnail = "https://randomuser.me/api/portraits/thumb/women/16.jpg"
                ),
                nat = "FI"
            ),
            User(
                gender = "male",
                name = Name(title = "Mr", first = "Oliver", last = "Hokkanen"),
                location = Location(
                    street = Street(number = 6012, name = "Korkeavuorenkatu"),
                    city = "Valtimo",
                    state = "Southern Ostrobothnia",
                    country = "Finland",
                    postcode = "39851",
                    coordinates = Coordinates(latitude = "-27.7216", longitude = "-168.8788"),
                    timezone = Timezone(offset = "+9:00", description = "Tokyo, Seoul, Osaka, Sapporo, Yakutsk")
                ),
                email = "oliver.hokkanen@example.com",
                login = Login(
                    uuid = "b2e95eb5-f984-49b0-a65c-cb5b76cec481",
                    username = "greenpeacock807",
                    password = "goaway",
                    salt = "7LHrJScx",
                    md5 = "2e3f7e2fab888e732db2d38fe2a95f1b",
                    sha1 = "d0ec023c7285834abac6166e89650193a7a7e82e",
                    sha256 = "1e381099fea5b866f153f834cfc161d8cf61a47212baaed9475fdd542667428e"
                ),
                dob = DateOfBirth(date = "1985-04-14T05:48:09.665Z", age = 39),
                registered = Registered(date = "2008-11-29T06:38:52.354Z", age = 15),
                phone = "05-389-725",
                cell = "040-514-02-00",
                id = Id(name = "HETU", value = "NaNNA037undefined"),
                picture = Picture(
                    large = "https://randomuser.me/api/portraits/men/69.jpg",
                    medium = "https://randomuser.me/api/portraits/med/men/69.jpg",
                    thumbnail = "https://randomuser.me/api/portraits/thumb/men/69.jpg"
                ),
                nat = "FI"
            ),
            User(
                gender = "male",
                name = Name(title = "Mr", first = "Oliver", last = "Hokkanen"),
                location = Location(
                    street = Street(number = 6012, name = "Korkeavuorenkatu"),
                    city = "Valtimo",
                    state = "Southern Ostrobothnia",
                    country = "Finland",
                    postcode = "39851",
                    coordinates = Coordinates(latitude = "-27.7216", longitude = "-168.8788"),
                    timezone = Timezone(offset = "+9:00", description = "Tokyo, Seoul, Osaka, Sapporo, Yakutsk")
                ),
                email = "oliver.hokkanen@example.com",
                login = Login(
                    uuid = "b2e95eb5-f984-49b0-a65c-cb5b76cec481",
                    username = "greenpeacock807",
                    password = "goaway",
                    salt = "7LHrJScx",
                    md5 = "2e3f7e2fab888e732db2d38fe2a95f1b",
                    sha1 = "d0ec023c7285834abac6166e89650193a7a7e82e",
                    sha256 = "1e381099fea5b866f153f834cfc161d8cf61a47212baaed9475fdd542667428e"
                ),
                dob = DateOfBirth(date = "1985-04-14T05:48:09.665Z", age = 39),
                registered = Registered(date = "2008-11-29T06:38:52.354Z", age = 15),
                phone = "05-389-725",
                cell = "040-514-02-00",
                id = Id(name = "HETU", value = "NaNNA037undefined"),
                picture = Picture(
                    large = "https://randomuser.me/api/portraits/men/69.jpg",
                    medium = "https://randomuser.me/api/portraits/med/men/69.jpg",
                    thumbnail = "https://randomuser.me/api/portraits/thumb/men/69.jpg"
                ),
                nat = "FI"
            )
        )
    }
}
