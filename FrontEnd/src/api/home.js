import { api } from "./index.js";

function getLocalList(map, success, fail) {
  api
    .post(`/home/local`, JSON.stringify(map), {
      headers: { "Content-Type": "application/json" },
    })
    .then(success)
    .catch(fail);
}

function getHotList(success, fail) {
  api.get(`/home/hot`).then(success).catch(fail);
}

export { getLocalList, getHotList };
