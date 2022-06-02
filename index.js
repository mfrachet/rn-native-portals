import PropTypes from "prop-types";
import { requireNativeComponent } from "react-native";
import {ViewPropTypes} from 'deprecated-react-native-prop-types';

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
