import React from "react";
import "./Firewall.css";

const Firewall = () => {
  return (
    <div className="content">
      <div className="firewall">
        <h1 className="firewall__title">Firewall</h1>
        <table className="firewall__table">
          <tr>
            <th className="firewall__heading">SRC IP</th>
            <th className="firewall__heading">DST IP</th>
            <th className="firewall__heading">CHAIN</th>
          </tr>
          <tr>
            <td>192.168.33.55</td>
            <td>8.8.8.8</td>
            <td>FORWARD</td>
            <td>
              <button className="firewall__btn delete">delete</button>
            </td>
          </tr>
        </table>
      </div>
      <div className="firewall blocked">
        <h1 className="firewall__title">
          Changing firewall from mobile device is forbidden!
        </h1>
      </div>
    </div>
  );
};

export default Firewall;
