import axios from "axios";
import Cookies from "js-cookie";

const API_URL = process.env.REACT_APP_BACKEND_URL;

axios.defaults.baseURL = API_URL;
axios.defaults.headers["Content-Type"] = "application/json";

export const setAuthToken = (token) => {
  Cookies.set("token", token, { secure: true });
};

export const getAuthToken = () => {
  return Cookies.get("token");
};

export const request = (method, endpoint, data) => {
  let headers = {};

  if (getAuthToken() !== undefined && getAuthToken() !== "undefined") {
    headers = { Authorization: "Bearer " + getAuthToken() };
  }

  return axios({
    method: method,
    headers: headers,
    url: endpoint,
    data: data,
  });
};
