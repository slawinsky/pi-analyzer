import axios from "axios";
import Cookies from "js-cookie";

const API_URL = process.env.REACT_APP_BACKEND_URL;

axios.defaults.baseURL = API_URL;
axios.defaults.headers.post["Content-Type"] = "application/json";

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

    const auth = getAuthToken();
    console.log(getAuthToken(auth));
  }

  return axios({
    method: method,
    headers: headers,
    url: endpoint,
    data: data,
  });
};
