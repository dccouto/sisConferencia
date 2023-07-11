import { ReactNode } from "react";
import { DesktopDrawer } from "./DesktopDrawer";
import { MobileDrawer } from "./MobileDrawer";
import { useDrawer } from "../hooks/useDrawer";

interface IResponsiveDrawerProps {
  children: ReactNode;
}

export function ResponsiveDrawer({ children }: IResponsiveDrawerProps) {
  const { isDesktop } = useDrawer();

  return isDesktop ? (
    <DesktopDrawer>{children}</DesktopDrawer>
  ) : (
    <MobileDrawer>{children}</MobileDrawer>
  );
}
