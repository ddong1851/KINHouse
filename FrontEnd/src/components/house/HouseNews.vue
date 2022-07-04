<template>
  <div id="panels">
    <div class="panel-1 py-5">
      <p class="text-sm text-left text-gray-600 font-bold py-2">
        부동산 실시간 뉴스
      </p>

      <div class="container flex justify-center mx-auto py-2">
        <div class="flex flex-col">
          <div class="w-full">
            <div class="border-b border-gray-200 shadow">
              <table class="divide-y divide-gray-300">
                <thead class="bg-gray-50">
                  <tr>
                    <th class="px-6 py-2 text-center text-gray-500">번호</th>
                    <th class="px-6 py-2 text-center text-gray-500">제목</th>
                  </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-300">
                  <tr
                    class="whitespace-nowrap"
                    v-for="(news, index) in newsData"
                    v-bind="news"
                    :key="index"
                  >
                    <td class="px-5 py-4 text-sm text-gray-500">
                      {{ index + 1 }}
                    </td>
                    <td class="px-3 py-4">
                      <div
                        class="text-sm text-gray-900 hover:text-blue-500 cursor-pointer"
                        @click="mvnews(news.originallink)"
                      >
                        {{ news.title }}
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "HouseNews",
  data() {
    return {
      newsData: [],
    };
  },
  mounted() {
    const API_URL = "http://localhost/house/news/`부동산`";
    axios
      .get(API_URL)
      .then((res) => {
        if (res.data == "") {
          alert("글이 없습니다");
        } else {
          this.newsData = res.data.items;
          for (var i = 0; i < 5; i++) {
            this.newsData[i].title = res.data.items[i].title.replace(
              /(<([^>]+)>)/gi,
              ""
            );
            if (this.newsData[i].title.length > 20) {
              this.newsData[i].title =
                this.newsData[i].title.substr(0, 20) + "...";
            }
          }
        }
      })
      .catch(() => {
        console.log("글 로드 실패");
      });
  },
  methods: {
    mvnews(originallink) {
      console.log("mvnews");
      window.open(originallink);
    },
  },
};
</script>

<style></style>
