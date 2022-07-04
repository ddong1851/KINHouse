import { api, instanceWithAuth } from "./index.js";

function submitReply(qna_reply, success, fail) {
  api
    .post(`/reply/register`, JSON.stringify(qna_reply), {
      headers: { "Content-Type": "application/json" },
    })
    .then(success)
    .catch(fail);
}

function getReply(qna_no, success, fail) {
  api.get(`/reply/list/${qna_no}`).then(success).catch(fail);
}

function deleteReplyItem(no, success, fail) {
  instanceWithAuth.delete(`/reply/delete/${no}`).then(success).catch(fail);
}

function modifyReplyItem(no, qna_reply, success, fail) {
  instanceWithAuth
    .put(`/reply/modify/${no}`, JSON.stringify(qna_reply), {
      headers: { "Content-Type": "application/json" },
    })
    .then(success)
    .catch(fail);
}

export { submitReply, getReply, deleteReplyItem, modifyReplyItem };
