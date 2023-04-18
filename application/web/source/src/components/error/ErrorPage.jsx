import React from "react";

const ErrorPage = ({error}) => {
  return (
    <div id="error">
      <h1 id="error-message">Oops there was an error</h1>
      <h1 id="custom-message">{error === undefined || error === null ? "Error 404: Page Not Found" : error.message}</h1>
    </div>
  );
};

export default ErrorPage;
