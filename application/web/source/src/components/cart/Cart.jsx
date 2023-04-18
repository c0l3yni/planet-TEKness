import React, { useEffect, useState } from "react";
import {
  getCartAmount,
  isCartEmpty,
} from "../../providers/cartProvider/CartProvider.js";
import { getCartParam } from "../../urlParams/getParams.js";
import formatAmountToUsd from "../../formatter/formatAmountToUsd.js";
import "./cart.css"

const Cart = () => {
  const [cartId, setCartId] = useState(null);
  useEffect(() => {
    setCartId(parseInt(getCartParam()));
  }, []);
  return (
    <div id="cart">
      <div className="cart-container">
        <h1>Cart</h1>
        <h1 id="cart-message">{isCartEmpty(cartId)}</h1>
      </div>
      <div className="subtotal-box">
        <h1 className="subtotal-label">Subtotal:</h1>
        <h1 id="cart-total-amount">{formatAmountToUsd(getCartAmount(cartId))}</h1>
      </div>
    </div>
  );
};

export default Cart;
