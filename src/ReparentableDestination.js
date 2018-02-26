import PropTypes from 'prop-types';
import { requireNativeComponent, ViewPropTypes } from 'react-native';

const iface = {
  name: 'ReparentableDestination',
  propTypes: {
    name: PropTypes.string.isRequired,
    children: PropTypes.oneOf([PropTypes.arrayOf(PropTypes.element), PropTypes.element]),
    ...ViewPropTypes,
  },
};

export default requireNativeComponent('RCTReparentableDestination', iface);
