package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.shared.SoliloquyClass;

//TODO: Document this interface
public interface BoxFactory extends SoliloquyClass {
    Box makeBox(BoxFactoryParams params);

    // NB: This might be a bit too far-flung to actually use
    //     My thought process is, the Box can be defined
    //     entirely by its parameters, allowing a completely
    //     custom Box, without requiring it to be defined by
    //     the UI engine in advance. This can allow for
    //     custom controllers, but that might require more
    //     specification than is allowed by BoxFactoryParams...
    //public Box makeBoxFromElements(Map<Integer,BoxFactoryParams> params);
}
