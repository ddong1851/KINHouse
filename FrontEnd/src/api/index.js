import axios from "axios";
import { API_BASE_URL, APT_DEAL_URL } from "@/config";
import { setInterceptors } from "@/api/common/interceptors.js";

// axios 객체 생성
function apiInstance() {
  const instance = axios.create({
    baseURL: API_BASE_URL,
    headers: {
      "Content-type": "application/json",
    },
  });
  return instance;
}

function houseInstance() {
  const instance = axios.create({
    baseURL: APT_DEAL_URL,
    headers: {
      "Content-type": "application/json",
    },
  });
  return instance;
}

function createInstanceWithAuth() {
  const instance = axios.create({
    baseURL: API_BASE_URL,
  });
  return setInterceptors(instance);
}

export const api = apiInstance();
export const instanceWithAuth = createInstanceWithAuth();
export { apiInstance, houseInstance };
