import React, { useEffect, useState } from "react";
import { getCartParam } from "../../urlParams/getParams";
import formatAmountToUsd from "../../formatter/formatAmountToUsd";
import { getCartAmount } from "../../providers/cartProvider/CartProvider.js";

export default function Payment() {
  const [amount, setAmount] = useState(0);

  useEffect(() => {
    setAmount(getCartAmount(parseInt(getCartParam())));
  }, []);

  return (
    <div id="payment">
      <form>
        <div id="source-field">
          <input type="radio" name="radio-answer" value="tok_amex" />
          American Express <br />
          <input type="radio" name="radio-answer" value="tok_visa" />
          Visa
          <br />
          <input type="radio" name="radio-answer" value="tok_mastercard" />
          Mastercard
          <br />
        </div>
        <div>
          Total: <span id="amount">{formatAmountToUsd(amount)}</span>
        </div>
      </form>
    </div>
  );
}
