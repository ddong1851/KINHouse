import { instanceWithAuth } from "./index.js";

function getQnaList(success, fail) {
  instanceWithAuth.get(`/qna/list`).then(success).catch(fail);
}

function register(qna, success, fail) {
  instanceWithAuth
    .post(`/qna/register`, JSON.stringify(qna), {
      headers: { "Content-Type": "application/json" },
    })
    .then(success)
    .catch(fail);
}

function getListItem(no, success, fail) {
  instanceWithAuth.get(`/qna/list/${no}`).then(success).catch(fail);
}

function removeQnaItem(no, success, fail) {
  instanceWithAuth.delete(`/qna/delete/${no}`).then(success).catch(fail);
}

function modifyItem(no, qna, success, fail) {
  instanceWithAuth
    .put(`/qna/modify/${no}`, JSON.stringify(qna), {
      headers: { "Content-Type": "application/json" },
    })
    .then(success)
    .catch(fail);
}

export { getQnaList, register, getListItem, removeQnaItem, modifyItem };
