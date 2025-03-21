import {
  LOGOUT,
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAILURE,
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAILURE,
} from "./ActionType";
import api from "../../common/api";

export const loginUser = (reqData) => async (dispatch) => {
  dispatch({ type: LOGIN_REQUEST });
  try {
    const { data } = await api.post(`/auth/signIn`, reqData.userData);
    if (data.jwt) localStorage.setItem("jwt", data.jwt);
    if (data.role === "ROLE_OWNER") {
      reqData.navigate("/admin/");
    } else {
      reqData.navigate("/");
    }
    dispatch({ type: LOGIN_SUCCESS, payload: data.jwt });
    console.log("login success", data);
  } catch (error) {
    dispatch({ type: LOGIN_FAILURE, payload: error });
    console.log("error", error);
  }
};
export const registerUser = (reqData) => async (dispatch) => {
  dispatch({ type: REGISTER_REQUEST });
  try {
    const { data } = await api.post("auth/register", reqData.userData);
    if (data.jwt) {
      localStorage.setItem("jwt", data.jwt);
    }
    if (data.role === "ROLE_OWNER") {
      reqData.navigate("/admin/");
    } else {
      reqData.navigate("/");
    }
    dispatch({ type: REGISTER_SUCCESS, payload: data.jwt });
    console.log("Register success");
  } catch (error) {
    dispatch({ type: REGISTER_FAILURE, payload: data.error });
    console.log("error", error);
  }
};
export const logoutUser = () => async (dispatch) => {
  try {
    localStorage.removeItem("jwt");
    dispatch({ type: LOGOUT });
    navigate("/");
    console.log("Logout successfully");
  } catch (error) {
    console.log("Error during logout ", error);
  }
};
