import React from "react";
import "./Hosts.css";

const Hosts = () => {
  return (
    <div className="content">
      <div className="hosts">
        <h1 className="hosts__title">Hosts</h1>
        <table className="hosts__table">
          <tr>
            <th className="hosts__heading ip">IP ADDRESS</th>
            <th className="hosts__heading mac">MAC ADDRESS</th>
            <th className="hosts__heading name">NAME</th>
            <th className="hosts__heading time">CONNECTION TIME</th>
          </tr>
          <tr>
            <td className="ip">192.168.33.55</td>
            <td className="mac">00-B0-D0-63-C2-26</td>
            <td className="name">POCO X3 PRO</td>
            <td className="time">02:34:50</td>
            <td>
              <button className="hosts__btn block">block</button>
            </td>
          </tr>
          <tr>
            <td className="ip">192.168.33.55</td>
            <td className="mac">00-B0-D0-63-C2-26</td>
            <td className="name">POCO X3 PRO</td>
            <td className="time">02:34:50</td>
            <td>
              <button className="hosts__btn block">block</button>
            </td>
          </tr>
          <tr>
            <td className="ip">192.168.33.55</td>
            <td className="mac">00-B0-D0-63-C2-26</td>
            <td className="name">POCO X3 PRO</td>
            <td className="time">02:34:50</td>
            <td>
              <button className="hosts__btn block">block</button>
            </td>
          </tr>
        </table>
        <button className="hosts__btn view">View blocked hosts {">>"}</button>
      </div>
    </div>
  );
};

export default Hosts;
