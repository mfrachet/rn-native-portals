import PropTypes from 'prop-types';
import { requireNativeComponent, ViewPropTypes } from 'react-native';

const iface = {
  name: 'ReparentableOrigin',
  propTypes: {
    destination: PropTypes.string,
    children: PropTypes.oneOf([PropTypes.arrayOf(PropTypes.element), PropTypes.element]),
    ...ViewPropTypes,
  },
};

export default requireNativeComponent('RCTReparentableOrigin', iface);
