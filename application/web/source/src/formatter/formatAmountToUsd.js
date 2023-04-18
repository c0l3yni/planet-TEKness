export default function formatAmountToUsd(amount) {
  const format = {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 2,
  };
  const usdFormat = Intl.NumberFormat("en-US", format);
  return usdFormat.format(amount / 100);
}
