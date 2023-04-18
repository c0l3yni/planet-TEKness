import formatAmountToUsd from "../src/formatter/formatAmountToUsd";

describe("format amount to usd test", () => {
  const scenarios = [
    [0, "$0.00"],
    [10, "$0.10"],
    [-50, "-$0.50"],
    [1111, "$11.11"]
  ];
  test.each(scenarios)("should return amount (%d) as string with dollar sign and two numbers after the decimal points", (amount, expected) => {
    const actual = formatAmountToUsd(amount);
    expect(actual).toEqual(expected);
  });
});
