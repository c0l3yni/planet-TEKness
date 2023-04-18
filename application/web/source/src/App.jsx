import { BrowserRouter, Route, Routes } from "react-router-dom";
import Payment from "./components/payment/Payment";
import Cart from "./components/cart/Cart";
import ErrorPage from "./components/error/ErrorPage";
import ErrorGenerator from "./components/error/ErrorGenerator";
import { ErrorBoundary } from "react-error-boundary";

function App() {
  return (
    <div className="App">
      <ErrorBoundary fallbackRender={ErrorPage}>
        <BrowserRouter>
          <Routes>
            <Route path="/payment" element={<Payment />} />
            <Route path="/cart" element={<Cart />} />
            <Route path="/error" element={<ErrorPage />} />
            <Route path="/error-generator" element={<ErrorGenerator />} />
            <Route path="*" element={<ErrorPage />} />
          </Routes>
        </BrowserRouter>
      </ErrorBoundary>
    </div>
  );
}

export default App;
