export default function getParams(query) {
    const params = new URL(window.location.href).searchParams;
    return params.get(query);
}

export function getCartParam(){
    return getParams("cart_id");
}