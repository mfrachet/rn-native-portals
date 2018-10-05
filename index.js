import PropTypes from "prop-types";
import { requireNativeComponent, ViewPropTypes } from "react-native";

const portalOrigin = {
  name: "PortalOrigin",
  propTypes: {
    name: PropTypes.string,
    ...ViewPropTypes
  }
};

const portalDestination = {
  name: "PortalDestination",
  propTypes: {
    destination: PropTypes.string,
    ...ViewPropTypes
  }
};

export const PortalOrigin = requireNativeComponent(
  "RCTPortalOrigin",
  portalOrigin
);

export const PortalDestination = requireNativeComponent(
  "RCTPortalDestination",
  portalDestination
);
