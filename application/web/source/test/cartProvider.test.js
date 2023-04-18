import { isCartEmpty, getCartAmount } from "../src/providers/cartProvider/CartProvider";

describe("check if cart is empty", () => {
  const scenarios = [
    [1, ""],
    [0, "Your cart is empty"],
  ];
  test.each(scenarios)("should return empty string", (cartId, expected) => {
    const actual = isCartEmpty(cartId);
    expect(actual).toEqual(expected);
  });
});


describe("getCartAmount test", () => {
  const scenarios = [
    [1, 50],
    [0, 0],
  ];
  test.each(scenarios)("should return cart amount", (cartId, expected) => {
    const actual = getCartAmount(cartId);
    expect(actual).toEqual(expected);
  });
});



