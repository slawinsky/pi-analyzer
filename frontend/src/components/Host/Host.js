import React from "react";

const Host = ({ ip, mac, name, time }) => {
  return (
    <>
      <tr>
        <td className="ip">{ip}</td>
        <td className="mac">{mac}</td>
        <td className="name">{name}</td>
        <td className="time">{time}</td>
        <td>
          <button className="hosts__btn btn-red block">block</button>
        </td>
      </tr>
    </>
  );
};

export default Host;
