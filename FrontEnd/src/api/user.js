import { api, instanceWithAuth } from "./index.js";
import { getAuthFromCookie } from "@/utils/cookies";

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function findById(id, success, fail) {
  api.defaults.headers["access-token"] = getAuthFromCookie();
  await api.get(`/user/info/${id}`).then(success).catch(fail);
}

function register(user, success, fail) {
  api.post(`/user/regist`, JSON.stringify(user)).then(success).catch(fail);
}

async function modifyUser(user, success) {
  return await api.put(`/user/modify`, JSON.stringify(user)).then(success);
}

function deleteUser(id, success, fail) {
  api.delete(`/user/delete/${id}`).then(success).catch(fail);
}

function findId(user, success, fail) {
  api.post(`/user/find/id`, JSON.stringify(user)).then(success).catch(fail);
}

function findPass(user, success, fail) {
  api.post(`/user/find/pass`, JSON.stringify(user)).then(success).catch(fail);
}

function checkDuplicated(user, success, fail) {
  api.post(`/user/check`, JSON.stringify(user)).then(success).catch(fail);
}

function getUserList(success, fail) {
  instanceWithAuth.get(`/user/list`).then(success).catch(fail);
}

function getUserLikedList(id, success, fail) {
  instanceWithAuth.get(`/user/liked/${id}`).then(success).catch(fail);
}

function deleteUserLikedItem(id, success, fail) {
  instanceWithAuth.delete(`/user/delete/item/${id}`).then(success).catch(fail);
}

export {
  login,
  register,
  modifyUser,
  deleteUser,
  findId,
  findPass,
  checkDuplicated,
  findById,
  getUserList,
  getUserLikedList,
  deleteUserLikedItem,
};
