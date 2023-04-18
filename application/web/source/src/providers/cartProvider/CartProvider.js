import cartJson from "../../data/cart.json";

export function isCartEmpty(cartId) {
  const cart = getCartById(cartId);
  if (cart === null || cart.items.length === 0) {
    return "Your cart is empty";
  } else {
    return "";
  }
}

export function getCartById(cartId) {
  let cartMatch = cartJson.filter((cart) => cart.id === cartId)[0];
  return cartMatch ? cartMatch : null;
}

export function getCartAmount(cartId) {
  const cart = getCartById(cartId);
  return !cart
    ? 0
    : cart.items.reduce((acc, item) => {
        acc += item.product.price * item.quantity;
        return acc;
      }, 0);
}
