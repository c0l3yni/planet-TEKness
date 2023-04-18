import { useEffect } from "react";

export default function ErrorGenerator() {
  useEffect(() => {
    throw new Error("test error");
  }, []);
}
