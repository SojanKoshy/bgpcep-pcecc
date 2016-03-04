/*
 * Copyright (c) 2016 Huawei Technologies Co. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.protocol.pcep.pcecc;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.List;
import org.opendaylight.protocol.pcep.spi.AbstractMessageParser;
import org.opendaylight.protocol.pcep.spi.MessageUtil;
import org.opendaylight.protocol.pcep.spi.ObjectRegistry;
import org.opendaylight.protocol.pcep.spi.PCEPDeserializerException;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.PclabelupdMessage;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.PclabelupdMessage;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.PclabelupdMessageBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.pclabelupd.message.Updates;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.pclabelupd.message.UpdatesBuilder;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.pclabelupd.message.updates.PcelabelUpdate;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.pclabelupd.message.updates.pcelabel.update.PcelabelDownload;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.pclabelupd.message.updates.pcelabel.update.PcelabelDownloadBuilder;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.pclabelupd.message.updates.pcelabel.update.PcelabelMap;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.pclabelupd.message.updates.pcelabel.update.PcelabelMapBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.pcecc.rev160225.pclabelupd.message.pclabelupd.message.updates.PcelabelUpdate;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.types.rev131005.Message;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.types.rev131005.Object;



/**
 * Parser for {@link PclabelupdMessage}
 */
public class PCEccLabelUpdateMessageParser extends AbstractMessageParser {

    public static final int TYPE = 57; // TODO

    public PCEccLabelUpdateMessageParser(final ObjectRegistry registry) {
        super(registry);
    }

    @Override
    public void serializeMessage(final Message message, final ByteBuf out) {
        Preconditions.checkArgument(message instanceof PclabelupdMessage, "Wrong instance of Message. Passed instance of %s. Need PceLabelUpdate.", message.getClass());
        final PclabelupdMessage msg = (PclabelupdMessage) message;
        final ByteBuf buffer = Unpooled.buffer();
        /*final List<Updates> updates = msg.getPceLabelUpdate().getUpdates();

        for (final Updates update : updates) {
            serializeUpdate(update, buffer);
        }*/
        MessageUtil.formatMessage(TYPE, buffer, out);
    }

    protected void serializeUpdate(final Updates update, final ByteBuf buffer) {

        // If label download

     // if label map

    }

    @Override
    protected Message validate(final List<Object> objects, final List<Message> errors) throws PCEPDeserializerException {
        Preconditions.checkArgument(objects != null, "Passed list can't be null.");
        if (objects.isEmpty()) {
            throw new PCEPDeserializerException("PcLabelUpt message cannot be empty.");
        }

        final List<PcelabelUpdate> updateRequests = Lists.newArrayList();

        while (!objects.isEmpty()) {
            final Updates upd = getValidUpdates(objects, errors);
            if(upd != null) {
                //updateRequests.add(upd);
            }
        }
        if (!objects.isEmpty()) {
            throw new PCEPDeserializerException("Unprocessed Objects: " + objects);
        }
        //return new PclabelupdMessageBuilder().setUpdates(new UpdatesBuilder().setPcelabelUpdate(updateRequests).build()).build();
        return null;
    }

    protected Updates getValidUpdates(final List<Object> objects, final List<Message> errors) {

        return null;
    }

}
