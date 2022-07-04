import { instanceWithAuth } from "./index.js";

function getList(success, fail) {
  instanceWithAuth.get(`/notice/list`).then(success).catch(fail);
}

function register(notice, success, fail) {
  instanceWithAuth
    .post(`/notice/regist`, JSON.stringify(notice), {
      headers: { "Content-Type": "application/json" },
    })
    .then(success)
    .catch(fail);
}

function getListItem(no, success, fail) {
  instanceWithAuth.get(`/notice/list/${no}`).then(success).catch(fail);
}

function removeItem(no, success, fail) {
  instanceWithAuth.delete(`/notice/delete/${no}`).then(success).catch(fail);
}

function modifyItem(no, notice, success, fail) {
  instanceWithAuth
    .put(`/notice/modify/${no}`, JSON.stringify(notice), {
      headers: { "Content-Type": "application/json" },
    })
    .then(success)
    .catch(fail);
}

export { getList, register, getListItem, removeItem, modifyItem };
