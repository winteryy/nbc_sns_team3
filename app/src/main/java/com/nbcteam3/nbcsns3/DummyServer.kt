package com.nbcteam3.nbcsns3

import com.nbcteam3.nbcsns3.entity.Post
import com.nbcteam3.nbcsns3.entity.User

object DummyServer {

    private var userList = listOf(
        User(
            uid = "go5zn7gbufel",
            userId = "Honggggg",
            password = "abc123D@",
            name = "홍길동",
            memo = "아버지를 아버지라 부르지 못하고",
            profileImageId = R.drawable.profile1
        ),
        User(
            uid = "g6fm98z5v9ou",
            userId = "Iron_Soo",
            password = "Ab#4",
            name = "김철수",
            memo = "영희랑",
            profileImageId = R.drawable.profile2
        ),
        User(
            uid = "k7h6gd7ys23x",
            userId = "YONGHEEDA",
            password = "yh5555@LEE",
            name = "이영희",
            memo = "MBTI: CUTE\n반오십 크리에이터\n협찬, 광고문의 DM으로, 저녁은 소고기국밥입니다 진짜 짱 맛있겠다 저녁으로 맛있는거 먹는건 국룰이지! 피자도 먹어야지~",
            profileImageId = R.drawable.profile3
        ),
        User(
            uid = "4sek8pedy2cx",
            userId = "dlwlrma",
            password = "1q2w3E&",
            name = "이지은",
            memo = "IU / 싱어송라이터\nH.E.R 2024.03.02~2024.09.22",
            profileImageId = R.drawable.profile4
        )
    )

    private val postList = listOf(
        Post(
            postId = "6cu82h1zhwmu",
            uid = "go5zn7gbufel",
            imageId = R.drawable.post1,
            title = "겨울 등산 준비물 도와주세요",
            content = "안녕하세요, 이번에 겨울 등산에 다녀올 예정입니다.\n겨울 등산에 필요한 준비물이 무엇이 있을까요?\n감사합니다!",
            dateTime = 20240401203211
        ),
        Post(
            postId = "xlrde3qaj7ml",
            uid = "g6fm98z5v9ou",
            imageId = R.drawable.post2,
            title = "대전 여행을 갔다 왔어요",
            content = "1박2일 빵 맛집 많다고 유명한 대전!\n풍경도 좋고 걸을 곳도 많고.\n산책 좋아하시고 디저트 좋아하시는 분들은 꼭 한 번 다녀오시길 바랍니다!",
            dateTime = 20240329162302
        ),
        Post(
            postId = "97z8o10hi4v1",
            uid = "k7h6gd7ys23x",
            imageId = R.drawable.post3,
            title = "이번에 전주 여행을 가게 되었습니다",
            content = "사진 찍을수 있는 캐릭터 음식점이 많네요.\n정말 예뻐서 사진찍기 좋아요 꼭 놀러가세요!",
            dateTime = 20240303211209
        ),
        Post(
            postId = "2h6w9hijx4yr",
            uid = "4sek8pedy2cx",
            imageId = R.drawable.post4,
            title = "H.E.R",
            content = "World Tour",
            dateTime = 20240324142015
        ),
        Post(
            postId = "xubi31d0i80f",
            uid = "k7h6gd7ys23x",
            imageId = R.drawable.post5,
            title = "대구 여행을 갔다 왔어요.",
            content = "더울줄 알았는데 춥네요... 바람이 많이 붑니다\n대구 가실때 따뜻하게 입고 가시는걸 추천드려요!",
            dateTime = 20240318231950
        ),
        Post(
            postId = "cg8jeohwt9yh",
            uid = "k7h6gd7ys23x",
            imageId = R.drawable.post6,
            title = "도봉산에 다녀왔어요",
            content = "첫 번째 산이니 가까운 산으로!\n생각보다 길이 험하네요, ㅜㅜ 초심자 주의!",
            dateTime = 20240310104812
        ),
        Post(
            postId = "9ahows70j26j",
            uid = "k7h6gd7ys23x",
            imageId = R.drawable.post7,
            title = "이번에는 단양으로 여행을 갔다 왔어요",
            content = "도담 삼봉! 유명하다 해서 가보았는데 초라하네요 \n그저 사진빨입니다 속지마세요.. 가지마세요...",
            dateTime = 20240227120353
        ),
        Post(
            postId = "ookhp4mog3w6",
            uid = "go5zn7gbufel",
            imageId = R.drawable.post8,
            title = "배낭 여행을 준비중 입니다 도와주세요",
            content = "배낭의 크기는 어느정도가 적당할까요? \n백팩에 어울리는 옷 추천 해주세요!",
            dateTime = 20240223134826
        )
    )

    fun loadPosts() = postList
    fun loadUsers() = userList

    fun registerUser(name: String, id: String, password: String) {
        val newList = userList.toMutableList()
        newList.add(
            User(
                uid = getNewId(),
                userId = id,
                password = password,
                name = name,
                memo = "상태메시지 없음",
                R.drawable.img
            )
        )
        userList = newList.toList()
    }

    private fun getNewId(): String {
        val charset = ('0'..'9') + ('a'..'z')
        var newId = List(12) { charset.random() }.joinToString("")
        while(userList.find { it.uid == newId } != null) {
            newId = List(12) { charset.random() }.joinToString("")
        }
        return newId
    }
}