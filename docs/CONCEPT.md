This library exposes 2 components:

* `ReparentableDestination`
* `ReparentableOrigin`

## ReparentableDestination

This is the portal destination. By default, it's empty. Its role is to _get_ some children and display them somewhere else
in the tree.

### Under the hood

Every time a `ReparentableDestination` is created, it's registered in a dictionary using its `name` props as key. When a `ReparentableOrigin` is created or rerendered,
if its props `destination` matches an item of the `ReparentableDestination` dictionary, its children are **moved**
(at a native level) from their current location, and become `ReparentableDestination` children.

In pseudo code (_this is not the real implementation, but it helps understanding the concept_) :

```javascript
class ReparentableOrigin {
  set destination(newDestination) {
    const destination = DestinationDictionary.get(newDestination);
    if (destination) {
      this.moveTo(destination); // move this, the current origin, to the matching destination
    }
  }
}
```

### API

* `name:String` (required): the unique identifier of the `ReparentableDestination`

## ReparentableOrigin

### Under the hood

Every time a `ReparentableOrigin` is created, it's registered in a dictionary using its `destination` props as key. When a `ReparentableDestination` is created,
if its props `name` exists in the `ReparentableOrigin` dictionary, the `ReparentableOrigin` children are moved to the `ReparentableDestination` and now become its children.

In pseudo code (_this is not the real implementation, but it helps understanding the concept_) :

```javascript
class ReparentableDestination {
  set name(newName) {
    const origin = OriginDictionary.get(newName);
    if (origin) {
      origin.moveTo(this); // move origin children to this, the matching destination
    }
  }
}
```

### API

* `destination:String`: the name of the `ReparentableDestination` target. If set, teleports the children to the matching `ReparentableDestination`.
  If `null`, simply restitute its children to their initial location.
