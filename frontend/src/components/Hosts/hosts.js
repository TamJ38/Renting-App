import React from "react";

const hosts = (props) => {
    return(
       <div className={"container mm-4 mt-5"}>
           <div className={"row"}>
               <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Surname</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.hosts.map((term) => {
                            return(
                                <tr>
                                    <td>{term.name}</td>
                                    <td>{term.surname}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
export default hosts;